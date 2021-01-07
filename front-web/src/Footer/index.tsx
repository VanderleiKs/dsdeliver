import './styles.css';
import {ReactComponent as Youtube} from './youtube.svg';
import {ReactComponent as Linkedin} from './linkedin.svg';
import {ReactComponent as Instagram} from './instagram.svg';

const Footer = () => (

    <footer className="main-footer">
        <p>App desenvolvido durante a 2ª ed. do evento Semana DevSuperior</p>
        <div className="footer-icons">
            <a href="youtube" target="_new"><Youtube /></a>
            <a href="linkedin" target="_new"><Linkedin /></a>
            <a href="instagran" target="_new"><Instagram /></a>
        </div>
    </footer>
);

export default Footer;