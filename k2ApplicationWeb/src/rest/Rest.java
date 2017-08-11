package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// javax.ws.rs.ApplicationPath: Imposta un'applicazione JAX-RS utilizzando solo annotazioni
// javax.ws.rs.core.Application: E' l'unico modo portatile di configurare risorse e provider in un servizio web JAX-RS. 
//                               Funziona bene solo nelle servlet container o negli application server che usano JAX-RS.
@ApplicationPath("/k2")
public class Rest extends Application{

}
