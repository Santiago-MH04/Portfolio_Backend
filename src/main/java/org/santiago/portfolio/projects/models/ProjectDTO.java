package org.santiago.portfolio.projects.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*@AllArgsConstructor*/
@NoArgsConstructor
@Data
@Builder
public class ProjectDTO {
        //Atributos de ProjectDTO
    private String _id;
    private String title;
    private List<String> keywords;
    private String logoUrl;

        //Constructores de ProjectDTO
    public ProjectDTO(String _id, String title, List<String> keywords, String logoUrl) {
        this._id = _id;
        this.title = title;
        this.keywords = keywords;
        this.logoUrl = logoUrl;
    }

    //Asignadores de atributos de ProjectDTO (setters)
    //Lectores de atributos de ProjectDTO (getters)
    //Métodos de ProjectDTO
}
