import "./card.css"; 

import { Pencil, Person, Trash } from 'react-bootstrap-icons';

function App() {
    return (
      <>
        <div> <Pencil /> Editar </div>
        <div> <Trash /> Excluir </div>
        <div> <Person/> Login </div>
      </>
    );
  }
  
  export default App;


interface CardProps {
    marca: string;
    modelo: string;
    ano: number;
    combustao: string;
    marchas: number;
    urlImagem: string;
    precoDiaria: number;
}

export function Card({ marca, modelo, ano, urlImagem, combustao, marchas, precoDiaria, }: CardProps) {
    return (
        <div className="card">
            <h2>{marca} {modelo} {ano}</h2>
<<<<<<< HEAD
            <h2> {marchas} <b>marchas</b> {combustao} </h2>
            <img src={urlImagem} alt={`${marca} ${modelo} ${combustao} ${marchas} Marchas`} />
            <p><b>Valor Diária: R$</b>{precoDiaria}</p>
            <div className="btnCard"> <button> <Pencil/> </button> <button> Locar </button>  <button > <Trash /> </button> </div>
=======
            <img src={urlImagem}/>
            <p><b>Valor Diária:</b>{precoDiaria}</p>
>>>>>>> f12afe8f26cdcf458f78e0031cd5ed7a44d68cec
        </div>
    );
}
