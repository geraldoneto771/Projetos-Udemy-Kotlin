package repository

import entity.ContactEntity

class ContactRepository {

    //mantendo os dados consistentes
    companion object {

        //criando uma variavel para salvar a lista de contatos num array
        private val contactList = mutableListOf<ContactEntity>()

        //criando a função de salvar os contatos
        fun save(contact: ContactEntity) {
            //adicionando o contato na lista
            contactList.add(contact)
        }

        //criando a função de remover contato
        fun delete(contact: ContactEntity) {
            var index = 0
            for (item in contactList.withIndex()) {

                if (item.value.name == contact.name && item.value.phone == contact.phone) {
                    index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        fun getList(): List<ContactEntity> {
            return contactList
        }
    }


}