import { useEffect, useState } from "react";
import { useCarroDataMutate } from "../../hooks/useCarroDataMutate";
import { CarroData } from "../../interface/CarroData";
import mlogo from "../images/mlogo.png";

import "./modal.css";

interface InputProps {
    label: string;
    value: string | number;
    updateValue(value: any): void;
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input 
                value={value} 
                onChange={event => updateValue(event.target.value)} 
            />
        </>
    );
}

interface ModalProps {
    closeModal(): void;
}

export function CreateModal({ closeModal }: ModalProps) {
    const [marca, setMarca] = useState("");
    const [modelo, setModelo] = useState("");
    const [ano, setAno] = useState(0);
    const [combustao, setCombustao] = useState("");
    const [marchas, setMarchas] = useState(0);
    const [urlImagem, setUrlImagem] = useState("");
    const [precoDiaria, setPrecoDiaria] = useState(0);
    const { mutate, isSuccess } = useCarroDataMutate();

    const submit = (event: React.FormEvent) => {
        event.preventDefault(); // Previne que o formulário seja submetido
        const carroData: CarroData = {
            marca,
            modelo,
            ano,
            urlImagem,
            combustao,
            marchas,
            precoDiaria
        };
        mutate(carroData);
    };

    useEffect(() => {
        if (isSuccess) {
            closeModal(); // Fecha o modal ao concluir a submissão com sucesso
        }
    }, [isSuccess, closeModal]);

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2><img className="logoSize2" src={mlogo} alt="Locadora de Carros"/></h2>
                <form className="input-container" onSubmit={submit}>
                    <Input label="Marca" value={marca} updateValue={(value) => setMarca(value.toUpperCase())}/>
                    <Input label="Modelo" value={modelo} updateValue={setModelo} />
                    <Input label="Ano" value={ano} updateValue={setAno} />
                    <Input label="URL da Imagem" value={urlImagem} updateValue={setUrlImagem} />
                    <Input label="Combustão" value={combustao} updateValue={setCombustao} />
                    <Input label="Marchas" value={marchas} updateValue={setMarchas} />
                    <Input label="Preço Diária" value={precoDiaria} updateValue={setPrecoDiaria} />
                    <div className="modal-buttons">
                        <button type="submit" className="btn-secondary">Cadastrar</button>
                        <button type="button" onClick={closeModal} className="btn-secondary">Voltar</button>
                    </div>
                </form>
            </div>
        </div>
    );
}
