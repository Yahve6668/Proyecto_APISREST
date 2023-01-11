
document.addEventListener('click',e=> {
    let btnSignIn=document.querySelector('.sign-up-btn'),
        btnSignUp=document.querySelector('.sign-in-btn'),
        signUp=document.querySelector('.sign-up'),
        signIn= document.querySelector('.sign-in');
        console.log(signUp);
  if(e.target==btnSignIn||e.target==btnSignUp){
    signIn.classList.toggle('active'),
    signUp.classList.toggle('active');
    }
})