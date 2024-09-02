package example.micronaut.gorm.controller

import example.micronaut.gorm.model.StudentModel
import example.micronaut.gorm.service.StudentService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/student")
class StudentController {
    @Inject
    StudentService studentService
    @Post
    def createStudent(@Body StudentModel studentModel){
        return studentService.createStudent(studentModel)
    }
}
