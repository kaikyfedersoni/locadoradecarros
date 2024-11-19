import "./card.css"; 

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
            <h2> {marchas} <b>marchas</b> {combustao} </h2>
            <img src={urlImagem} alt={`${marca} ${modelo} ${combustao} ${marchas} Marchas`} />
            <p><b>Valor Diária: R$</b>{precoDiaria}</p>
        </div>
    );
}
