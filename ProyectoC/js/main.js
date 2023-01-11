const fila = document.querySelector('.contenedor-carousel');
const peliculas = document.querySelectorAll('.pelicula');

const flechaIzquierda = document.getElementById('flecha-izquierda');
const flechaDerecha = document.getElementById('flecha-derecha');
const lugar =document.querySelector(".carousel");

const divpeli=document.createElement('div');
const Poster=document.createElement('img');
divpeli.setAttribute('class','pelicula');
const apeli=document.createElement('a');
function random(min, max) {
	return Math.floor(Math.random() * (max - min + 1) + min);
  }
var npeliculas=0;
async function load(movie){
	let til=[];
	let pos=[]; 
	for(let i=0;i<150;++i){
		let id="tt01";
	    id+=random(10000,90000);
		let API_URL="http://www.omdbapi.com/?i="+id+"&apikey=208a05f2";
		const res=await fetch(API_URL);
		const data=await res.json();
		if(data.Response=="True"&&data.Title!="N/A"&&data.Poster!="N/A"&&data.Genre!="N/A"){
		   let candi=data.Genre.split(',');
			for(let j=0;j<candi.length;++j){
			   if(movie[candi[j]]!=undefined){
				console.log(data.Title);
				til.push(data.Title);
				pos.push(data.Poster);
				break;
			  }
		   }	
     	}
	}
	npeliculas=pos.length;
	recupera(pos,til);
}


async function recomendacion(){ 
	let gpelicu= await fetch("js/gustospeli.php");
	let resg= await gpelicu.json();
	let  map = {};
	for(let j=0;j<resg.length;++j){
        let key=resg[j];
		map[key]='1';
	}
	 let genero=await fetch("js/gustosgene.php");
     let resge= await genero.json();
	 for(let j=0;j<resge.length;++j){
         let key=resg[j];
    		map[key]='1';
	}
	load(map);
}



function recupera(peli,titulos){
	for(let i=0;i<peli.length;++i){
			let divpeli=document.createElement('div');
			divpeli.setAttribute('class','pelicula');
			divpeli.innerHTML= "<a href=" + " #> " + "<img src=" + peli[i]+ " alt=''>" +titulos[i] +"</a>";
			lugar.appendChild(divpeli);
			console.log(titulos[i]);
		}
}


async function gustos(){
 let p= await fetch("registro.php");
 let pg=await p.json();       
 
 let g= await fetch("registro.php");
 let gg=await p.json();

}
// ? ----- ----- Event Listener para la flecha derecha. ----- -----
flechaDerecha.addEventListener('click', () => {
	fila.scrollLeft += fila.offsetWidth;
	const indicadorActivo = document.querySelector('.indicadores .activo');
	if(indicadorActivo.nextSibling){
		indicadorActivo.nextSibling.classList.add('activo');
		indicadorActivo.classList.remove('activo');
	}
});

// ? ----- ----- Event Listener para la flecha izquierda. ----- -----
flechaIzquierda.addEventListener('click', () => {
	fila.scrollLeft -= fila.offsetWidth;

	const indicadorActivo = document.querySelector('.indicadores .activo');
	if(indicadorActivo.previousSibling){
		indicadorActivo.previousSibling.classList.add('activo');
		indicadorActivo.classList.remove('activo');
	}
});

// ? ----- ----- Paginacion ----- -----
const numeroPaginas = Math.ceil(peliculas.length / 5);
for(let i = 0; i < 3; i++){
	const indicador = document.createElement('button');

	if(i === 0){
		indicador.classList.add('activo');
	}

	document.querySelector('.indicadores').appendChild(indicador);
	indicador.addEventListener('click', (e) => {
		fila.scrollLeft = i * fila.offsetWidth;

		document.querySelector('.indicadores .activo').classList.remove('activo');
		e.target.classList.add('activo');
	});
}

// ? ----- ----- Hover ----- -----
peliculas.forEach((pelicula) => {
	pelicula.addEventListener('mouseenter', (e) => {
		const elemento = e.currentTarget;
		setTimeout(() => {
			peliculas.forEach(pelicula => pelicula.classList.remove('hover'));
			elemento.classList.add('hover');
		}, 300);
	});
});

fila.addEventListener('mouseleave', () => {
	peliculas.forEach(pelicula => pelicula.classList.remove('hover'));
});