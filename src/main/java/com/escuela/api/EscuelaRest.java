package com.escuela.api;


import com.escuela.domain.TAlumno;
import com.escuela.domain.TCalificacion;
import com.escuela.service.EscuelaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.List;

@Path("v1")
public class EscuelaRest {
    @Inject
    EscuelaService escuelaService;

    @Path("ping")
    @GET
    public Response ping(){
        return Response.ok().entity("Ping Exitoso").build();
    }

    @Path("getAlumnos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnos(){
        List<TAlumno> alumnos = escuelaService.getAllAlumnos();
        return Response.ok().entity(alumnos).build();
    }

    @Path("set/calificacion/")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCalificaion(
            TCalificacion calificacion
    ){
        JSONObject response = new JSONObject();

        try {
            String res = escuelaService.setCalificacion(calificacion);

            response = new JSONObject(res);
            System.out.println(response.toString());
        }catch (Exception ex){
            response.put("success","false");
            response.put("msg",ex.getMessage());
            ex.printStackTrace();
        }

        return Response.ok().entity(response.toString()).build();
    }

    @Path("add/calificacion/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCalificaion(
            TCalificacion calificacion
    ){
        JSONObject response = new JSONObject();
        calificacion.setFechaRegistro(LocalDate.now());
        try {
            String res = escuelaService.addCalificion(calificacion);
            response = new JSONObject(res);
        }catch (Exception ex){
            response.put("success","false");
            response.put("msg",ex.getMessage());
            ex.printStackTrace();
        }
        return Response.ok().entity(response.toString()).build();
    }

    @Path("get/calificaciones/{idAlumno}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCalificaciones(@PathParam("idAlumno")int idAlumno){
        JSONArray response = escuelaService.consultarCalificaciones(idAlumno);
        return Response.ok().entity(response.toString()).build();
    }

    @Path("delete/calificacion/{idAlumno}/{idMateria}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCalificaciones(@PathParam("idAlumno")int idAlumno,@PathParam("idMateria")int idMateria){
        TCalificacion calificacion = new TCalificacion();
        calificacion.setIdTMaterias(idMateria);
        calificacion.setIdTUsuarios(idAlumno);
        System.out.println(calificacion.toString());
        String response = escuelaService.eliminarCalificacion(calificacion);
        return Response.ok().entity(response).build();
    }
    @Path("get/materias")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaterias(){
        JSONArray response = new JSONArray( escuelaService.getAllMaterias());
        return Response.ok().entity(response.toString()).build();
    }
}
