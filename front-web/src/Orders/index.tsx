import { useEffect, useState } from 'react';
import { FetchProducts } from '../api';
import OrderLocation from './OrderLocation';
import ProductList from './ProductList';
import StepsHeader from './StepsHeader';
import './styles.css';
import { OrderLocationData, Product } from './types';

const Orders = () => {
    const [products, setProduscts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {
        FetchProducts().then(response => setProduscts(response.data))
        .catch(error => console.log(error))

    }, []);

    return (
        <div className="orders-container">
            <StepsHeader />
            <ProductList products={products}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
        </div>

    )
}

export default Orders;