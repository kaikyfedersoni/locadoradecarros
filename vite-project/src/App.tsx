
import { useState } from 'react';
import './App.css';
import { Card } from './components/card/card';
import { useCarroData } from './hooks/UseCarroData';
import { CreateModal } from './components/createModal/createModal';

function App() {
  const { data } = useCarroData();
  const [isModalOpen,setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  return (
    <div className="container">
      <h1>Locadora de Carros</h1>
      <div className="card-grid">
        {data?.map(CarroData => 
          <Card 
            marca={CarroData.marca} 
            modelo={CarroData.modelo}
            ano={CarroData.ano}
            urlImagem={CarroData.urlImagem}
            precoDiaria={CarroData.precoDiaria}
          />
        )}
      </div>
      {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
      <button onClick={handleOpenModal}>novo</button>
    </div>
  );
}

export default App;
