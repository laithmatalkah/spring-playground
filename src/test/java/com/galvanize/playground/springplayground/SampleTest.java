package com.galvanize.playground.springplayground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SampleTest {

    @Mock
    public LessonRepository lessonRepository;

    @InjectMocks
    public LessonsController lessonsController;

    @Test
    public void test_save() {

        Date d = new Date();
        Lesson lesson = new Lesson();
        lesson.setId(11L);
        lesson.setTitle("Topic 1");

        Lesson lessonReturned = new Lesson();
        lessonReturned.setId(12L);
        lessonReturned.setTitle("Topic 2");

        when(lessonRepository.save(lesson)).thenReturn(lessonReturned);
        assertThat(lessonRepository.save(lesson), is(lessonReturned));
        assertThat(lessonRepository.save(lesson).getTitle(), is("Topic 1"));


    }

    @Test
    public void test_all() {

        Lesson lesson1 = new Lesson();
        lesson1.setId(11L);
        lesson1.setTitle("Topic 1");

        Lesson lesson2 = new Lesson();
        lesson2.setId(12L);
        lesson2.setTitle("Topic 2");

        List<Lesson> lesssons = Arrays.asList(lesson1, lesson2);
        when(lessonRepository.findAll()).thenReturn(lesssons);

        List<Lesson> returnedLessons = (List<Lesson>) lessonsController.all();
        assertThat(returnedLessons.size(), is(2));

    }
}
