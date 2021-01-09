import { Product } from "./types";

export const checkIsSelected = (selectedProducts: Product[], product: Product) => {
   return selectedProducts.some(item => item.id === product.id);
}

export const FormaterPrice = (price: number) => {
   const fomratter = Intl.NumberFormat('pt-BR', {
       style: 'currency',
       currency: 'BRL',
       minimumFractionDigits: 2
   })
   return fomratter.format(price);
}