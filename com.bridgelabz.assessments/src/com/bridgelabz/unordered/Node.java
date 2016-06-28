package com.bridgelabz.unordered;

/*
* created by: BridgeLabz
* Date 19/05/2016
*
* Perpose: model class for Node
**/

public class Node<E>{

	private E data;
	public Node right;
	public Node left;

	public Node(E data){
		this.data=data;
		right=null;
		left=null;
	}

	public Node(E data,Node right,Node left){
		this.data=data;
		this.right=right;
		this.left=left;
	}

	public void setData(E data){
		this.data=data;
	}

	public E getData(){
		return data;
	}

}