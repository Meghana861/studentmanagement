package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class StudentDomain {

    String name
    String email
    String phoneNumber
    int age
    static hasMany = [courses:CourseDomain]

    static mapping = {
        courses fetch:"join"
    }
}
