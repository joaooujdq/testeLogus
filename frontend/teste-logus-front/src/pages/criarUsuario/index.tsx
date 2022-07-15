import Footer from '../../components/basics/footer';
import Header from '../../components/basics/header';
import Title from  '../../components/basics/title';
import CriarUsuarioBody from 'components/basics/criarUsuarioBody';

const CriarUsuario: React.FC = () => {
    return (

        <>
            <Title />
            <Header />
            <CriarUsuarioBody />
            <Footer />
        </>
    );
}

export default CriarUsuario;