import "./card.css";

interface CardProps {
    marca: string;
    modelo: string;
    ano: number;
    urlImagem: string;
    precoDiaria: number;
}

export function Card({ marca, modelo, ano, urlImagem, precoDiaria }: CardProps) {
    return (
        <div className="card">
            <img src={urlImagem}/>
            <h2>{marca}</h2>
            <h2>{modelo}</h2>
            <h2>{ano}</h2>
            <p><b>Valor Diária:</b>{precoDiaria}</p>
        </div>
    );
}
