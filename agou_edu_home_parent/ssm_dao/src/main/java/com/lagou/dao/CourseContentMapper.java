package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    /*根据课程id查询关联的章节信息以及关联的课时信息*/
    public List<CourseSection> findSectionAndLessionByCourseId(Integer courseId);

    /*回显章节对应的课程信息*/
    public Course findCourseByCourseId(int courseId);

    /*新增章节信息*/
    public void saveSection(CourseSection section);

    public void saveLesson(CourseLesson lesson);

    /*更新章节信息*/
    void updateSection(CourseSection section);

    /*修改章节状态*/
    public void updateSectionStatus(CourseSection section);

    void updateLesson(CourseLesson lesson);
}
