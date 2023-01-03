package com.champis.api;


import com.champis.domain.TAlumno;
import com.champis.service.AlumnosService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("v1")
public class EscuelaRest {
    @Inject
    AlumnosService alumnosService;

    @Path("ping")
    @GET
    public Response ping(){
        return Response.ok().entity("Ping Exitoso").build();
    }

    @Path("getAlumnos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnos(){
        List<TAlumno> alumnos = alumnosService.getAllAlumnos();
        return Response.ok().entity(alumnos).build();
    }
}
