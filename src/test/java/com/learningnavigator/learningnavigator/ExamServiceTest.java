package com.learningnavigator.learningnavigator;

@RunWith(MockitoJUnitRunner.class)
public class ExamServiceTest {

    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamService examService;

    @Test
    public void testGetExamById() {
        // Mock data
        Long examId = 1L;
        Exam exam = new Exam();
        exam.setId(examId);
        when(examRepository.findById(examId)).thenReturn(Optional.of(exam));

        // Test
        Exam result = examService.getExamById(examId);

        // Verify
        assertEquals(examId, result.getId());
    }

    // Add more test cases for other methods in the ExamService class
}

