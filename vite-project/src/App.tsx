
import { useState } from 'react';
import './App.css';
import { Card } from './components/card/card';
import { useCarroData } from './hooks/UseCarroData';
import { CreateModal } from './components/createModal/createModal';
import logo from './components/images/logo.png';
import {Instagram, Person, Whatsapp} from 'react-bootstrap-icons';

function App2() {
    return (
      <>
        <div> <Person/> Login </div>
        <div> <Instagram/> Instagram </div>
        <div> <Whatsapp/> Whatsapp  </div>
        
      </>
    );
  }




function App() {
  const { data } = useCarroData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev); 
  };

  return (
    <div>
      <img className="logoSize" src={logo} alt="Locadora de Carros" />  
      <div className='Inline'>
        <div className='espacamento'>
          {isModalOpen && <CreateModal closeModal={handleOpenModal} />} 
          <button> Buscar </button>
          <button onClick={handleOpenModal}>Cadastrar Novo Veículo</button>
          <div className='espacamentoLogin'>
          <button className="btnLogin"> 
               <Whatsapp className="iconSize"/> 
            </button>  
          <button className="btnLogin"> 
               <Instagram className="iconSize"/> 
            </button>
            <button className="btnLogin"> 
               <Person className="iconSize"/> 
            </button>
          </div>
        </div>
      </div> 
      <div className="container">
        <div className="card-grid">
          {data?.map(CarroData => 
            <Card 
              key={CarroData.id} 
              marca={CarroData.marca} 
              modelo={CarroData.modelo}
              ano={CarroData.ano}
              combustao={CarroData.combustao}
              marchas={CarroData.marchas}
              urlImagem={CarroData.urlImagem}
              precoDiaria={CarroData.precoDiaria}
            />
          )}
        </div> 
      </div>
    </div>
  );
}


export default App;
