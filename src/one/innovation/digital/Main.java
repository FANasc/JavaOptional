package one.innovation.digital;

import java.util.Optional;

/*************************************************************************************
 *
 * Objetivo: 1) Criar um Optional de um determinado dado.
 *           2) Criar um estado vazio, presente e null.
 *           3) Se presente, exibir o valor no console.
 *           4) Se vazio, lance uma exceção IlegalsStateIlegal.
 *           5) Se vazio, exibir "Optional vazio" no console.
 *           6) Se presente, transforme o valor e exiba no console.
 *           7) Se presente, pegue o valor e exiba no console.
 *           8) Se presente, filtre o optional com uma determinada regra de negócio.
 *  Autor  : Fernando Aguiar
 *  Data   : 04.08.2021
 *
 *************************************************************************************/
public class Main {

    public static void main(String[] args) {

        // (1) Criar um Optional de um determinado dado.
        // (2) Criar um estado vazio, presente e null.
        Optional<Integer> optionalInteiroVazio = Optional.empty();
        Optional<Integer> optionalInteiroPresente = Optional.of(1234);
        Optional<Integer> optionalInteiroNulo = Optional.ofNullable(null);

        // (3) Se presente, exibir o valor no console.
        optionalInteiroPresente.ifPresentOrElse((valor) -> System.out.println("Valor Presente: " + valor), () -> System.out.println("Valor não está presente"));

        // (4) Se vazio, lance uma exceção IlegalsStateIlegal.
        optionalInteiroVazio = Optional.of(5678);
        optionalInteiroVazio.orElseThrow(IllegalStateException::new);

        // (5) Se vazio, exibir "Optional vazio" no console.
        optionalInteiroVazio = Optional.empty();
        optionalInteiroVazio.ifPresentOrElse((valor) -> System.out.println("Valor Presente: " + valor), () -> System.out.println("Opcional vazio"));

        // (6) Se presente, transforme o valor e exiba no console.
        optionalInteiroPresente.map((valor) -> valor.toString().concat(" metros")).ifPresent(System.out::println);

        // (7) Se presente, pegue o valor e exiba no console.
        if (optionalInteiroPresente.isPresent()) {
            Integer valor = optionalInteiroPresente.get();
            System.out.println("Valor via .get(): " + valor);
        }

        // (8) Se presente, filtre o optional com uma determinada regra de negócio.
        if (optionalInteiroVazio.isEmpty()) {
            System.out.println("Optional está vazia!");
        } else {
            System.out.println("Optional possui valor!");
        }
    }
}