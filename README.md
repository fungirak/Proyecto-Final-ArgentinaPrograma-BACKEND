# PROYECTO FINAL DE ARGENTINA PROGRAMA 
# EDICIÓN 2021/2022 | MÓDULO "YO PROGRAMO" 
# by GABRIEL LAZZARINI.

# **********   DOCUMENTACIÓN DE LA API    ***********
 
 Sistema Backend escrito en lenguaje Java, utilizando Framework Spring.
 
 # ENDPOINTS
 LINK DEL SERVIDOR EN VIVO: https://proyecto-final-arg-prog.herokuapp.com/ 
 
 ENTIDADES: AcercaDe, Educacion, Experiencias, Skills, Proyectos.
 
 EL SISTEMA CUENTA CON AUTENTICACIÓN BASADA EN TOKEN (JsonWebToken).
 
 #  *** OPEN ***
    REGISTRO: 
    
    LOGIN:
    https://proyecto-final-arg-prog.herokuapp.com/auth/login
 
 # *** LOCK ***
 
   # METHOD GET 
     All
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/acerca_de
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/educacion
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/experiencias
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/skills
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/proyectos

     One
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/acerca_de/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/educacion/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/experiencias/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/skills/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/proyectos/id
         
   # METHOD POST
     
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/acerca_de
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/educacion
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/experiencias
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/skills
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/proyectos

   
   # METHOD PUT & DELETE
     One
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/acerca_de/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/educacion/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/experiencias/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/skills/id
         https://proyecto-final-arg-prog.herokuapp.com/api/v1/proyectos/id
   
 
 
    
  PARA EJECUTAR LAS PETICIONES EL USUARIO DEBE ESTAR LOGUEADO, 
  DE LO CONTRARIO RECIBIRÁ UN ERROR 401: NO AUTORIZADO.
  
  ESTE PROYECTO SE ENCUENTRA EN ETAPA DE FINALIZACIÓN.

  
  
 
 
