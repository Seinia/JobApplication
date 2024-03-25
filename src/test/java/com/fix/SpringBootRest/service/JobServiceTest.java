package com.fix.SpringBootRest.service;


import com.fix.SpringBootRest.model.JobPost;
import com.fix.SpringBootRest.repo.JobRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

    @Mock
    private JobRepo repo;

    @InjectMocks
    private JobService service;

    @Test
    public void shouldReturnJob(){
        int postId = 1;

        Mockito.when(repo.findById(postId)).thenReturn(Optional.of(getJobPost()));

        JobPost jobPost = service.getJob(postId);

        Assertions.assertNotNull(jobPost);
        Assertions.assertEquals(postId, jobPost.getPostId()); // перевірка ідентифікатора поста
        Assertions.assertEquals("1", jobPost.getPostDesc()); // перевірка опису поста
        Assertions.assertIterableEquals(List.of("1","2"), jobPost.getPostTechStack()); // перевірка технологічного стеку
        Assertions.assertEquals(4, jobPost.getReqExperience()); // перевірка необхідного досвіду
        Assertions.assertEquals("Dmitro", jobPost.getPostProfile()); // перевірка профілю поста
    }

    private JobPost getJobPost(){
        JobPost jobPost = new JobPost();

        jobPost.setPostId(1);
        jobPost.setPostDesc("1");
        jobPost.setPostTechStack(List.of("1","2"));
        jobPost.setReqExperience(4);
        jobPost.setPostProfile("Dmitro");


        return jobPost;
    }

}
