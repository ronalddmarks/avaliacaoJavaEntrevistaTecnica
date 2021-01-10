package br.com.spassu.service;
import java.util.*;
public class ListaDeObjetos<E>
{	
	private ArrayList<E> lista;
	private int corrente = -1;

	public ListaDeObjetos (int tam)
	{	lista = new ArrayList<E>(tam);		
	}

	public boolean adicionar(E obj)
	{	return lista.add(obj);	
	}

	public int tamanho()
	{	return lista.size();
	}

	public boolean remover(int numero)
	{	int n = this.localizar(numero);
		if(n != -1)
		{	lista.remove(n);
			return true;
		}
		else
		{	return false;
		}	
	}
	private int localizar(int numero)
	{		
		Integer num = new Integer(numero);
		
		for(int i=0; i<lista.size(); i++)
		{	if(lista.get(i).equals(num))
			{	
				return i;
			}
		}
		return -1;
	}

	public E recuperar(int numero)
	{	
		int n = this.localizar(numero);
		
		if (n != -1)
			return lista.get(n);
		else
			return null;	
	}

	public boolean vazia()
	{	return lista.isEmpty();
	}

	public E recuperarPrimeiro()
	{	if(lista.isEmpty())
			return null;
		else
		{	corrente = 0;
			return lista.get(corrente);
		}	
	}
						
	public E recuperarProximo()
	{	if(corrente == -1)
		{	throw new ArrayIndexOutOfBoundsException("Tentativa de acesso invalido");
		}		
		
		corrente++;
		if(corrente < lista.size())
			return lista.get(corrente);
		else
		{	corrente = -1;
			return null;
		}
	}
}









