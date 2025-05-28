package org.santiago.portfolio.projects.services;

import org.santiago.portfolio.projects.models.Project;
import org.santiago.portfolio.projects.models.ProjectDTO;
import org.santiago.portfolio.projects.repositories.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
        //Atributos de ProjectServiceImpl
    private final ProjectRepository repoProject;

        //Constructores de ProjectServiceImpl
    public ProjectServiceImpl(ProjectRepository repoProject) {
        this.repoProject = repoProject;
    }

    //Asignadores de atributos de ProjectServiceImpl (setters)
    //Lectores de atributos de ProjectServiceImpl (getters)
        //Métodos de ProjectServiceImpl
    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return this.repoProject.findAll();
    }
        @Override
        @Transactional(readOnly = true)
        public List<ProjectDTO> findAllMiniatures() {
            return this.repoProject.findProjectDTOMiniatures();
        }
        @Override
        public List<ProjectDTO> findRandomMiniatures() {
            List<ProjectDTO> allProjectDTOMiniatures = this.repoProject.findProjectDTOMiniatures();
            if(allProjectDTOMiniatures.size() <= 3){    //Una vez haya probado, cambiar de 3 a 7
                return allProjectDTOMiniatures;
            }
                //Mezclar la lista aleatoriamente
            Collections.shuffle(allProjectDTOMiniatures);
                //Devolver los elementos que encontró
            return allProjectDTOMiniatures.subList(0,3);
        }
        @Override
            @Transactional(readOnly = true)
            public Page<Project> findProjectsPaginated(int page, int size) {
                PageRequest pageRequest = PageRequest.of(page, size);
                return this.repoProject.findAll(pageRequest);
            }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findById(String id) {
        return this.repoProject.findById(id);
    }

    @Override
    @Transactional
    public Project create(Project project) {
        return this.repoProject.save(project);
    }

    @Override
    @Transactional
    public Optional<Project> update(String id, Project project) {
        return this.repoProject.findById(id)
            .map(p -> {
                if(project.getTitle() != null || !project.getTitle().isBlank()){
                    p.setTitle(project.getTitle());
                }
                if(project.getDescription() != null || !project.getDescription().isBlank()){
                    p.setDescription(project.getDescription());
                }
                if(project.getKeywords() != null || !project.getKeywords().isEmpty()){
                    p.setKeywords(project.getKeywords());
                }
                if(project.getLogoUrl() != null || !project.getLogoUrl().isBlank()){
                    p.setLogoUrl(project.getLogoUrl());
                }
                if(project.getImageUrls() != null || !project.getImageUrls().isEmpty()){
                    p.setKeywords(project.getImageUrls());
                }
                if(project.getNeedsToFix() != null || !project.getNeedsToFix().isBlank()){
                    p.setNeedsToFix(project.getNeedsToFix());
                }
                if(project.getSolutionsProposed() != null || !project.getSolutionsProposed().isBlank()){
                    p.setSolutionsProposed(project.getSolutionsProposed());
                }


                return this.repoProject.save(p);
            });
    }

    @Override
    @Transactional
    public void delete(String id) {
        this.repoProject.deleteById(id);
    }
}
