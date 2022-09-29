package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseByCourseId(int courseId);

    /*新增章节信息*/
    public void saveSection(CourseSection section);

    /*更新章节信息*/
    void updateSection(CourseSection section);

    public void updateSectionStatus(int id,int status);

    public void saveLesson(CourseLesson lesson);

    void updateLesson(CourseLesson lesson);
}
