package business
import entity.ContactEntity
import repository.ContactRepository
import  java.lang.Exception

class ContactBusiness {
    //criando a função para validar os dados
    private fun validade(name: String, phone: String) {
        //verificando se o campo nome não está vazio
        if (name == "") {
            throw Exception("Nome é obrigatório!")
        }
        //verificando se o campo telefone não está vazio
        if (phone == "") {
            throw Exception("Telefone é obrigatório!")
        }
    }
    // criando uma função para validar se o usuário selecionou o contato
    private fun validadeDelete(name: String, phone: String) {
        if(name == "" || phone == "") {
            throw Exception("Por favor selecione um contato para remover!")
        }
    }

    fun getContactCountDescription(): String {
        val list = getList()
        return when{
            list.isEmpty() -> "0 contatos"
            list.size == 1 -> "1 contato"
            else -> "${list.size} contatos"

        }

    }
    //criando a função de salvar
    fun save(name: String, phone: String) {
        //chamando a função para validar os dados
        validade(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }
    //criando a função de remover contato
    fun delete(name: String, phone: String) {
        //chamando a função para validar os dados
        validadeDelete(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)

    }
    fun getList() : List<ContactEntity> {
        return ContactRepository.getList()
    }
}