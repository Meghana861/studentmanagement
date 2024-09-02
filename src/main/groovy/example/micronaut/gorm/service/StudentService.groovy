package example.micronaut.gorm.service

import example.micronaut.gorm.domain.CourseDomain
import example.micronaut.gorm.domain.StudentDomain
import example.micronaut.gorm.model.StudentModel
import grails.gorm.transactions.Transactional

import javax.inject.Singleton

@Singleton
class StudentService {
    @Transactional
    def createStudent(StudentModel studentModel){
        StudentDomain studentDomain=new StudentDomain()
        studentDomain.name=studentModel.name
        studentDomain.email=studentModel.email
        studentDomain.phoneNumber=studentModel.phoneNumber
        studentDomain.age=studentModel.age
        studentDomain.save()
        studentDomain.courses=studentModel.courses.each{courseModel->
            CourseDomain courseDomain=new CourseDomain()
            courseDomain.courseName=courseModel.courseName
            courseDomain.credits=courseModel.credits
            courseDomain.save()
            studentDomain.addToCourses(courseDomain)
        }
        def savedStudent=studentDomain.save()
//        return convertEntityToModel(savedStudent)
        return "Added Student Successfullly"

    }

//    static StudentModel convertEntityToModel(StudentDomain studentDomain){
//        return new studentModel(
//                studentModel.name=studentDomain.name
//                studentModel.email=studentModel.email
//                studentModel.phoneNumber=studentModel.phoneNumber
//                studentModel.age=studentModel.age
//        )
//    }

    @Transactional
    def getAllStudents(){
        List<StudentDomain>
    }
}
