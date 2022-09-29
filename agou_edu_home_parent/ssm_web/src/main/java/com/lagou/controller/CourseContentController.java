package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService contentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam int courseId) {
        List<CourseSection> list = contentService.findSectionAndLessonByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "课程查询成功", list);
        return responseResult;
    }

    /*回显章节课程信息*/
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId) {
        Course course = contentService.findCourseByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询章节课程信息成功", course);
        return responseResult;
    }

    /*新增更新章节信息*/
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section) {
        if(section.getId() == null){
            contentService.saveSection(section);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增章节课程信息成功", null);
            return responseResult;
        } else {
            contentService.updateSection(section);
            ResponseResult responseResult = new ResponseResult(true, 200, "更新章节课程信息成功", null);
            return responseResult;
        }

    }

    /**
     * 修改章节状态
     * 状态，0:隐藏；1：待更新；2：已发布
     * */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam int id, @RequestParam int status){
        contentService.updateSectionStatus(id, status);
        Map<Object, Object> map = new HashMap<>();
        map.put("status", status);

        ResponseResult result = new ResponseResult(true, 200, "修改章节状态成功", map);
        return  result;
    }

    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson lesson){
        try {
            if(lesson.getId() == null){
                contentService.saveLesson(lesson);
                return new ResponseResult(true,200,"响应成功",null);
            }else{
                contentService.updateLesson(lesson);
                return new ResponseResult(true,200,"响应成功",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
