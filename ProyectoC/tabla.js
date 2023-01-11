async function api(b){
  let arr=[];
  for(let i=0;i<b.length;++i){
    let API_URL="http://www.omdbapi.com/?i="+b[i]+"&apikey=208a05f2";
    const res=await fetch(API_URL);
    const data=await res.json();
     if(data.Response=="True"){
        console.log(data.Poster);
        arr.push(data.Title);
        arr.push(data.Poster);
    }
  }
  return arr;
}

async function gustos(){
    let res=await fetch("pelif.php");
    let r= await res.json();
    let arr=[];
    let selector=document.getElementById('tabla');
    arr= await api(r);    
    for(let i=0;i<arr.length;i+=2){
        let tr=document.createElement('tr');
        let td=document.createElement('td');
        let td2=document.createElement('td');
         let textoCelda = document.createTextNode(arr[i]); 
         let imagen=document.createElement('img');
         td.appendChild(textoCelda);
         imagen.setAttribute('src',arr[i+1]);
         td2.appendChild(imagen);
         tr.appendChild(td);
         tr.appendChild(td2);     
         selector.appendChild(tr);
    }
} 

