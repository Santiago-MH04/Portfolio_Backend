package org.santiago.portfolio.projects.controllers;

import org.santiago.portfolio.projects.models.Project;
import org.santiago.portfolio.projects.models.ProjectDTO;
import org.santiago.portfolio.projects.services.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})   //Para que lo pueda consumir cualquier front
@RequestMapping("/api/projects")
public class ProjectController {
        //Atributos de ProjectController
    private final ProjectService projectService;

        //Constructores de ProjectController
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Asignadores de atributos de ProjectController (setters)
    //Lectores de atributos de ProjectController (getters)
        //Métodos de ProjectController
    @GetMapping
    public List<Project> findAll(){
        return this.projectService.findAll();
    }
    @GetMapping({ "/miniatures", "miniatures/{option}" })
    public List<ProjectDTO> getMiniatures(@PathVariable(name = "option", required = false) String option) {
        if (option != null && option.equalsIgnoreCase("random")) {
            return projectService.findRandomMiniatures();
        }
        return projectService.findAllMiniatures();
    }

    @GetMapping("/paginated")
        public ResponseEntity<Page<Project>> findAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ){
            return ResponseEntity.ok(this.projectService.findProjectsPaginated(page, size));
        }
            @GetMapping("/{id}")
            public ResponseEntity<Project> findById(@PathVariable String id){
                /*return ResponseEntity.status(HttpStatus.OK)
                        .body(this.projectService.findById(id)
                            .orElseThrow()
                        );*/

                return this.projectService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElseThrow();
            }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.projectService.create(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable String id, @RequestBody Project project){
        return this.projectService.update(id, project)
            .map(ResponseEntity::ok)
            .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void removeProject(@PathVariable String id){
        this.projectService.delete(id);
    }
}
