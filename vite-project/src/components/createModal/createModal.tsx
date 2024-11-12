import { useEffect, useState } from "react";
import { useCarroDataMutate } from "../../hooks/useCarroDataMutate";
import { CarroData } from "../../interface/CarroData";

import "./modal.css"

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}


const Input = ({ label, value , updateValue }: InputProps) =>{
    return (
        <>
            <label>{label}</label>
            <input value ={value} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}

interface ModalProps {
    closeModal(): void

}


export function CreateModal({closeModal}:ModalProps){

    const [marca,setMarca] = useState("");
    const [modelo,setModelo] = useState("");
    const [ano,setAno] = useState(0);
    const [urlImagem,setUrlImagem] = useState("");
    const [precoDiaria,setPrecoDiaria] = useState(0);
    const {mutate, isSuccess} = useCarroDataMutate();
    const submit = () => {
        const CarroData: CarroData = {
            marca,
            modelo,
            ano,
            urlImagem,
            precoDiaria
        }
        mutate(CarroData)
    }

    useEffect(() => {
        if(!isSuccess) return
            closeModal();
        
    }, [isSuccess])
    return(
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo carro</h2>
                <form className = "input-container">
                    <Input label="marca" value={marca} updateValue={setMarca} ></Input>
                    <Input label="modelo" value={modelo} updateValue={setModelo}></Input>
                    <Input label="ano" value={ano} updateValue={setAno}></Input>
                    <Input label="urlImagem" value={urlImagem} updateValue={setUrlImagem}></Input>
                    <Input label="precoDiaria" value={precoDiaria} updateValue={setPrecoDiaria}></Input>
                </form>
                <button onClick={submit} className="btn-secondary"> </button>
            </div>
        </div>
    )
}
