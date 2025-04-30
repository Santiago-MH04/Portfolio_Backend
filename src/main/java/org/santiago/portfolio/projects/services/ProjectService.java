package org.santiago.portfolio.projects.services;

import org.santiago.portfolio.projects.models.Project;
import org.santiago.portfolio.projects.models.ProjectDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    //Atributos de ProjectService
    //Constructores de ProjectService
    //Asignadores de atributos de ProjectService (setters)
    //Lectores de atributos de ProjectService (getters)
        //Métodos de ProjectService
    List<Project> findAll();
        List<ProjectDTO> findRandomMiniatures();
        Page<Project> findProjectsPaginated(int page, int size);
    Optional<Project> findById(String id);
    Project create(Project project);
    Optional<Project> update(String id, Project project);
    void delete(String id);
}
