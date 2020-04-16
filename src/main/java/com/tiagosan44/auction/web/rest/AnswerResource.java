package com.tiagosan44.auction.web.rest;


import com.tiagosan44.auction.domain.Answer;
import com.tiagosan44.auction.repository.AnswerRepository;
import com.tiagosan44.auction.repository.QuestionRepository;
import com.tiagosan44.auction.web.rest.errors.ResourceNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnswerResource {

	AnswerRepository answerRepository;

	QuestionRepository questionRepository;

	@GetMapping("/questions/{questionId}/answers")
	public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
		return answerRepository.findByQuestionId(questionId);
	}

	@PostMapping("/questions/{questionId}/answers")
	public ResponseEntity<Object> addAnswer(@PathVariable Long questionId,
                                            @Valid @RequestBody Answer answer) {
		return questionRepository.findById(questionId)
				.map(question -> {
					answer.setQuestion(question);
					answerRepository.save(answer);
					URI answerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}").buildAndExpand(answer.getId()).toUri();
					return ResponseEntity.created(answerLocation).build();
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

	@PutMapping("/questions/{questionId}/answers/{answerId}")
	public Answer updateAnswer(@PathVariable Long questionId,
			@PathVariable Long answerId,
			@Valid @RequestBody Answer answerRequest) {
		if(!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with id " + questionId);
		}

		return answerRepository.findById(answerId)
				.map(answer -> {
					answer.setText(answerRequest.getText());
					return answerRepository.save(answer);
				}).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
	}

	@DeleteMapping("/questions/{questionId}/answers/{answerId}")
	public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
                                          @PathVariable Long answerId) {
		if(!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with id " + questionId);
		}

		return answerRepository.findById(answerId)
				.map(answer -> {
					answerRepository.delete(answer);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));

	}
}
