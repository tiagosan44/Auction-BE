package com.tiagosan44.auction.web.rest;


import com.tiagosan44.auction.domain.Question;
import com.tiagosan44.auction.repository.QuestionRepository;
import com.tiagosan44.auction.web.rest.errors.ResourceNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuestionResource {

	QuestionRepository questionRepository;

	@GetMapping("/questions")
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}

	@GetMapping("/questions/{questionId}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long questionId) {
		return questionRepository.findById(questionId)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

	@PostMapping("/questions")
	public Question createQuestion(@Valid @RequestBody Question question) {
		return questionRepository.save(question);
	}

	@PutMapping("/questions/{questionId}")
	public Question updateQuestion(@PathVariable Long questionId,
			@Valid @RequestBody Question questionRequest) {
		return questionRepository.findById(questionId)
				.map(question -> {
					question.setTitle(questionRequest.getTitle());
					question.setDescription(questionRequest.getDescription());
					return questionRepository.save(question);
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}


	@DeleteMapping("/questions/{questionId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
		return questionRepository.findById(questionId)
				.map(question -> {
					questionRepository.delete(question);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}
}
