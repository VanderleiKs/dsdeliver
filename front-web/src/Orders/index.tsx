import { useEffect, useState } from 'react';
import { FetchProducts, saveOrder } from '../api';
import Footer from '../Footer';
import { checkIsSelected } from './helpers';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrerSummary';
import ProductList from './ProductList';
import StepsHeader from './StepsHeader';
import { toast } from 'react-toastify';
import './styles.css';
import { OrderLocationData, Product } from './types';

const Orders = () => {
    const [products, setProduscts] = useState<Product[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
    const totalPrice = selectedProducts.reduce((sum, item) => {
        return sum + item.price
    }, 0);

    useEffect(() => {
        FetchProducts().then(response => setProduscts(response.data))
        .catch(error => console.log(error))

    }, []);

    const handleSelectProduct = (product: Product) => {
        const isAlreadySelected = checkIsSelected(selectedProducts, product);
      
        if (isAlreadySelected) {
          const selected = selectedProducts.filter(item => item.id !== product.id);
          setSelectedProducts(selected);
        } else {
          setSelectedProducts(previous => [...previous, product]);
        }
      }

      const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }));
        const payload = {
          ...orderLocation!,
          products: productsIds
        }
      
        saveOrder(payload).then((response) => {
          toast.error(`Pedido enviado com sucesso! N° ${response.data.id}`);
          setSelectedProducts([]);
        })
          .catch(() => {
            toast.warning('Erro ao enviar pedido');
          })
      }

    return (
        <>
        <div className="orders-container">
            <StepsHeader />
            <ProductList
            selectedProducts={selectedProducts}
            onSelectProduct={handleSelectProduct}
            products={products}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
            <OrderSummary 
            amount={selectedProducts.length} 
            totalPrice={totalPrice} 
            onSubmit={handleSubmit}
            />
        </div>
        <Footer />
        </>
    )
}

export default Orders;