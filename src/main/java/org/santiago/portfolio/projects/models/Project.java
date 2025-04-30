package org.santiago.portfolio.projects.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Project {
        //Atributos de Project (los atributos deben llamarse igual al campo de la base de datos o llevar la anotación @Field(name="nombre_campo"))
    @Id
    private String _id;
    private String title;
    private String description;
    private List<String> keywords;
    private String link;
    private String logoUrl;
    private List<String> imageUrls;
    private String needsToFix;
    private String solutionsProposed;

    //Constructores de Project
    //Asignadores de atributos de Project (setters)
    //Lectores de atributos de Project (getters)
    //Métodos de Project
}
