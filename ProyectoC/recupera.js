const lugar =document.getElementById("coloca");
var nche=0;
function inyecta(valores){
    let a=document.getElementById("coloca"); 
    let r=valores;
    nche=r.length;
    for(let ar=0;ar<r.length;ar+=2){
        let labe2=document.createElement('label');
        labe2.setAttribute('value','pelicula');
        labe2.innerHTML="<input type='checkbox' value="+(ar)+" class='check' id=checkbox"+ar+"></input>"+r[ar];
        a.appendChild(labe2);
        let labe=document.createElement('label');
        labe.setAttribute('value','pelicula');        
        let i=ar;
        ++i;
        labe.innerHTML=" &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='checkbox' value="+( i )+" class='check' id=checkbox"+(ar+1)+"></input>"+r[ar+1]+"<br>";
        a.appendChild(labe);
    }
}
function option(opc,seccion){
    let a=document.getElementById(seccion); 
    for(let i=0;i<opc.length;i+=3){
       let r=opc[i]+","+opc[i+1]+","+opc[i+2];
       let op=document.createElement('option');
       let texto=document.createTextNode(r);
       op.value=i+1;
       op.appendChild(texto);
       a.appendChild(op); 
    }
   
}

async function load(tipo,seccion){
    let response = await fetch(tipo); 
    let dato= await response.json();
        if(seccion==0){
        inyecta(dato);
        }else{
        option(dato,(seccion==1?"autores":"directores")   );
        }
}
function prese(){
    load('recupera.php',0);
    load('recuperator.php',1);
    load('recuperadir.php',2);    
}
function redirecciona(where){
       location.href=where;
}

function crea_forma(objeto) {
    let res = new FormData( );
    for (let campo in objeto) {
       res.append(campo, (typeof(objeto[campo]) == 'object' ? JSON.stringify(objeto[campo]) : objeto[campo]));
    }
    return res;
 }

 async function reuser(movie){
	let API_URL="http://localhost:8081/Proyecto/webresources/check";
     const res=await fetch("http://localhost:8081/Proyecto/webresources/check", { method: 'GET',
     mode: 'cors', // <---
     cache: 'default'
  });
	 const data=await res.json();
     return Object.keys(data)[Object.keys(data).length-1];
}
async function s(movie){
    let API_URL="http://www.omdbapi.com/?s="+movie+"&page=1"+"&apikey=208a05f2";
     const res=await fetch(API_URL);
	 const data=await res.json();
	 if(data.Response=="True"){
		return data.Search;
	 }
}
var titulos=[];
async function token(cadena){
     let arrc=cadena.split(',');
     if(arrc.length==3){
       let id=[];
            for(let i=0;i<3;++i){
                let t=await s(arrc[i]);
                id.push(t[0].imdbID);
                console.log(t[0].Title + " "+t[0].imdbID) ;
                titulos.push(arrc[i]);
            }
        return id;
    }
    return false;
}
var arr=[];
async function check(){
    for(let a=0;a<nche;++a){
        let revi=document.getElementById("checkbox"+a);
        if (revi.checked){
            arr.push(a+1);
        }
    }
    let user=await reuser("");
    alert(user);
    let peli=document.getElementById('pelis').value;
    let actores=document.getElementById('autores').value;
    let direc=document.getElementById('directores').value;
    let pelif= await token(peli);
    
    if(direc != 0&&actores != 0 &&peli != ""&&nche!=0){
        let respuesta = await fetch("registro.php", {
              "method": "POST",
              "body": crea_forma({
                "User":user,
                 "generos":arr,
                 "peliculas":pelif,
                 "titulos":titulos,
                 "actores":actores,
                 "directores":direc
              })
          });
       let a=await respuesta.text( );
       arr= [];
       titulos=[];
       nche=0;
       alert(a);
       if(a=="exito"){
          redirecciona("http://localhost:8080/ProyectoC/principal.html");
       }
    }else{
        alert("llena todos los campos");
    }  
}