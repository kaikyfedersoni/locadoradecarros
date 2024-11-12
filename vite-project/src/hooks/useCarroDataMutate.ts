import axios, { AxiosPromise } from "axios"
import { CarroData } from "../interface/CarroData";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";

const API_URL = 'http://localhost:8080'

const postData = async(data:CarroData): AxiosPromise<any> => {
    const response = axios.post(API_URL + '/carro',data);
    return response;
}
export function useCarroDataMutate(){
    const mutate = useMutation({
    mutationFn: postData,
    retry:2,
})
 
return mutate;
}