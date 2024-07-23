function newBigArr(){

                return {

                                length:0n,

                                push:function(x){

                                                                this[this.length]=x;

                                                                this.length++;

                                                                return this;

                                                },

                                pop:function(){

                                                                const x=this[this.length-1n];

                                                                delete this[this.length-1n];

                                                                this.length--;

                                                                return x;

                                                },

                                get:function(x){

                                                                return this[BigInt(x)];

                                                },

                                set:function(x,y){

                                                                return this[BigInt(x)]=y;

                                                }

                                }

}