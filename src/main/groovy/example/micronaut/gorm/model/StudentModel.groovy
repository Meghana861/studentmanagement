package example.micronaut.gorm.model

import example.micronaut.gorm.domain.CourseDomain


class StudentModel {
    String name
    String email
    String phoneNumber
    int age
    Set<CourseDomain> courses
}
