# PROYECTO FINAL DE ARGENTINA PROGRAMA 
# EDICIÓN 2021/2022 | MÓDULO "YO PROGRAMO" 
# by GABRIEL LAZZARINI.

# **********   DOCUMENTACIÓN DE LA API    ***********
 
 Sistema Backend escrito en lenguaje Java, utilizando Framework Spring.
 
 # ENDPOINTS
 LINK DEL SERVIDOR EN VIVO: https://argentina-programa-portafolio.herokuapp.com/
 
 ENTIDADES: AcercaDe, Educacion, Experiencias, Skills, Proyectos.
 
 EL SISTEMA CUENTA CON AUTENTICACIÓN BASADA EN TOKEN (JsonWebToken).
 
 #  *** OPEN ***
    REGISTRO: 
    
    LOGIN:
    https://argentina-programa-portafolio.herokuapp.com/auth/login
 
 # *** LOCK ***
 
   # METHOD GET 
     All
         https://argentina-programa-portafolio.herokuapp.com/api/v1/acerca_de
         https://argentina-programa-portafolio.herokuapp.com/api/v1/educacion
         https://argentina-programa-portafolio.herokuapp.com/api/v1/experiencias
         https://argentina-programa-portafolio.herokuapp.com/api/v1/skills
         https://argentina-programa-portafolio.herokuapp.com/api/v1/proyectos

     One
         https://argentina-programa-portafolio.herokuapp.com/api/v1/acerca_de/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/educacion/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/experiencias/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/skills/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/proyectos/id
         
   # METHOD POST
     
         https://argentina-programa-portafolio.herokuapp.com/api/v1/acerca_de
         https://argentina-programa-portafolio.herokuapp.com/api/v1/educacion
         https://argentina-programa-portafolio.herokuapp.com/api/v1/experiencias
         https://argentina-programa-portafolio.herokuapp.com/api/v1/skills
         https://argentina-programa-portafolio.herokuapp.com/api/v1/proyectos

   
   # METHOD PUT & DELETE
     One
         https://argentina-programa-portafolio.herokuapp.com/api/v1/acerca_de/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/educacion/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/experiencias/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/skills/id
         https://argentina-programa-portafolio.herokuapp.com/api/v1/proyectos/id
   
 
 
    
  PARA EJECUTAR LAS PETICIONES EL USUARIO DEBE ESTAR LOGUEADO, 
  DE LO CONTRARIO RECIBIRÁ UN ERROR 401: NO AUTORIZADO.
  
  ESTE PROYECTO SE ENCUENTRA EN ETAPA DE FINALIZACIÓN.

  
  
 
 
