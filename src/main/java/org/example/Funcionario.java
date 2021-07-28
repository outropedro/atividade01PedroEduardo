package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Funcionarios{
    Scanner teclado = new Scanner(System.in);

    private String nome, sexo;//nascimento é a data de nascimento
    Date nascimento;
    private int idade;
    private String dataRecebida;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Funcionarios> bdFuncionarios = new ArrayList<Funcionarios>();


    public Funcionarios(String nome, String sexo, Date nascimento, int idade, ArrayList<Funcionarios> bdFuncionarios) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.idade = idade;
        this.bdFuncionarios = bdFuncionarios;
    }

    public Funcionarios() {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.idade = idade;
        this.bdFuncionarios = bdFuncionarios;
    }


    public ArrayList<Funcionarios> getBdFuncionarios() {
        return bdFuncionarios;
    }

    public void setBdFuncionarios(ArrayList<Funcionarios> bdFuncionarios) {

        bdFuncionarios.add(new Funcionarios());

        this.bdFuncionarios = bdFuncionarios;
    }
//    public void bdFuncionariosAdd(String nome, String sexo, Date nascimento, int idade {
//        nome = getNome();
//        sexo = getSexo();
//        nascimento = getNascimento();
//        idade = getIdade();
//
//        bdFuncionarios.add(new Funcionarios());
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
//        GregorianCalendar hj=new GregorianCalendar();
//        GregorianCalendar nascimento=new GregorianCalendar();
//        if(getNascimento()!=null){
//            nascimento.setTime(getNascimento());
//        }
//        int anohj=hj.get(Calendar.YEAR);
//        int anoNascimento=nascimento.get(Calendar.YEAR);
//        return new Integer(anohj-anoNascimento);

        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void cadastraFuncionario() throws ParseException {
        String opcaoCadastro;

        if (bdFuncionarios.size()<3){
            for (int i=0; i<= bdFuncionarios.size(); i++){
                System.out.println("Insira o nome do funcionario(a): ");
                this.nome = teclado.nextLine();
                setNome(nome);

                System.out.println("Insira o sexo do(a) funcionario(a): ");
                this.sexo = teclado.nextLine();
                setSexo(sexo);

                System.out.println("Inisra a dara de nascimento do(a) funcionario(a):  ");
                dataRecebida = teclado.nextLine();

                Date dataFormatada = formato.parse(dataRecebida);
                setNascimento(dataFormatada);
                GregorianCalendar hj=new GregorianCalendar();
                GregorianCalendar nascimento=new GregorianCalendar();
                if(getNascimento()!=null){
                    nascimento.setTime(getNascimento());
                }
                int anohj=hj.get(Calendar.YEAR);
                int anoNascimento=nascimento.get(Calendar.YEAR);
                idade = new Integer(anohj-anoNascimento);
                setIdade(idade);

                setBdFuncionarios(bdFuncionarios);
                System.out.println(i);
                System.out.println(bdFuncionarios.size());

                if (bdFuncionarios.size()>=3){
                    System.out.println("Você deseja cadastrar mais funcionario?\nSim\nNão");
                    opcaoCadastro = teclado.nextLine();
                    if(opcaoCadastro.equals("Sim")){
                        cadastraFuncionario();
                    }
                    else if(opcaoCadastro.equals("Não")){
                        System.out.println("Foi um prazer auxilia-lo, qualquer coisa só executar novmamente");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Opção unvalida. Selecione uma opção valida");
                        cadastraFuncionario();
                    }

                }
            }
        }
        else {
            this.nome = teclado.nextLine();
            setNome(nome);
            teclado.nextLine();

            System.out.println("Insira o sexo do(a) funcionario(a): ");
            this.sexo = teclado.nextLine();
            setSexo(sexo);
            teclado.nextLine();

            System.out.println("Inisra a dara de nascimento do(a) funcionario(a):  ");
            dataRecebida = teclado.nextLine();
            teclado.nextLine();
            teclado.nextLine();
            teclado.nextLine();

            Date dataFormatada = formato.parse(dataRecebida);
            setNascimento(dataFormatada);
            GregorianCalendar hj=new GregorianCalendar();
            GregorianCalendar nascimento=new GregorianCalendar();
            if(getNascimento()!=null){
                nascimento.setTime(getNascimento());
            }
            int anohj=hj.get(Calendar.YEAR);
            int anoNascimento=nascimento.get(Calendar.YEAR);
            idade = new Integer(anohj-anoNascimento);
            setIdade(idade);

            setBdFuncionarios(getBdFuncionarios());


            System.out.println("Você deseja cadastrar mais funcionario?\nSim\nNão");
            opcaoCadastro = teclado.nextLine();
            teclado.nextLine();
            if(opcaoCadastro.equals("Sim")){
                cadastraFuncionario();
            }
            else if(opcaoCadastro.equals("Não")){
                System.out.println("Foi um prazer auxilia-lo, qualquer coisa só executar novmamente");
                System.exit(0);
            }
            else{
                System.out.println("Opção unvalida. Selecione uma opção valida");
                cadastraFuncionario();
            }
        }
    }

    public void emitirRelatorio() throws ParseException {
        int contM = 0, contF = 0;
        int idadeTotal = 0, idadeTotalM = 0, idadeTotalF = 0, mediaIdadeGeral, mediaIdadeF, mediaIdadeM;

        if(bdFuncionarios.size()<10){
            System.out.println("Não teem 10 funcionarios cadastrados ainda, favor cadastrar.");
            cadastraFuncionario();
        }
        else {
            for (int i = 0; i <= bdFuncionarios.size(); i++) {
                Iterator it = bdFuncionarios.iterator();

                while (it.hasNext()) {
                    System.out.println(it.next());

                    if(sexo.equals("Feminino")){
                        contF++;
                        idadeTotalF += idade;
                    }
                    else if(sexo.equals("Masculino")){
                        contM++;
                        idadeTotalM += idade;

                    }
                    idadeTotal += idade;

                }

                int totalS=contM + contF;
                int percentualF = (totalS - contF)*100;
                int percentualM = (totalS - contM)*100;
                mediaIdadeGeral = idadeTotal/totalS;
                mediaIdadeF = idadeTotalF/contF;
                mediaIdadeM = idadeTotalM/contM;
                System.out.println("A quantidade de funcionairios do sexo feminino é " + contF + " representando " + percentualF + "%");
                System.out.println("A quantidade de funcionairios do sexo masculino é " + contM + " representando " + percentualM + "%");
                System.out.println("A media de idade dos funcionarios é " + mediaIdadeGeral + " anos.");
                System.out.println("A idade de  idade das funcionarias do sexo feminino é de " + mediaIdadeF + "anos.");
                System.out.println("A idade de  idade das funcionarios do sexo masculino é de " + mediaIdadeM + "anos.");

            }
        }
    }
    public void teste(){
        Iterator it = bdFuncionarios.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
