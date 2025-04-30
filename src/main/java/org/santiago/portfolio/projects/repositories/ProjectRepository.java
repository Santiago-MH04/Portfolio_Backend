package org.santiago.portfolio.projects.repositories;

import org.santiago.portfolio.projects.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    //Atributos de ProjectRepository
    //Constructores de ProjectRepository
    //Asignadores de atributos de ProjectRepository (setters)
    //Lectores de atributos de ProjectRepository (getters)
        //Métodos de ProjectRepository

        //Así, devuelve todos los campos especificados, sin ninguna condición, y los transforma en mi clase DTO
    @Query(value = "{}",  fields = "{title: 1, keywords: 1, logoUrl: 1, _id: 0}")
    List<org.santiago.portfolio.projects.models.ProjectDTO> findProjectDTOMiniatures();
}
