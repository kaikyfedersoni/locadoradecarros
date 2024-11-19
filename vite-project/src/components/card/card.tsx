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
            <h2>{marca} {modelo} {ano}</h2>
            <img src={urlImagem}/>
            <p><b>Valor Diária:</b>{precoDiaria}</p>
        </div>
    );
}
