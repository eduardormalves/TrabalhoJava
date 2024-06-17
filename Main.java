import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		ArrayList<Participante> p = new ArrayList<>();
		ArrayList<Evento> e = new ArrayList<>();
		ArrayList<Organizador> o = new ArrayList<>();
		ArrayList<Inscricao> i = new ArrayList<>();
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("-----Gerenciador de Eventos-----");
			System.out.println("[1] - Cadastrar (Organizador, Evento, Participante)");
			System.out.println("[2] - Listar (Organizadores, Eventos, Participantes, Inscrições)");
			System.out.println("[3] - Visualizar Obj. Especif.");
			System.out.println("[4] - Excluir (Organizador, Evento, Participante, Inscrições)");
			System.out.println("[5] - Editar (Organizador, Evento, Participante)");
			System.out.println("[6] - Relacionar Inscricão com Evento e Participante");
			System.out.println("[0] - Sair");
			System.out.println("--------------------------------");
			option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("--------------------------------");
				System.out.println("[1] - Cadastrar Organizador");
				System.out.println("[2] - Cadastrar Evento");
				System.out.println("[3} - Cadastrar Participante");
				System.out.println("--------------------------------");
				int opcao = sc.nextInt();
				switch(opcao) {
				case 1:
					System.out.println("Digite o ID do organizador:");
				    int idOrg = sc.nextInt();
				    boolean ExisteIdOrg = false;
				    for (Organizador org : o) {
				        if (org.getId() == idOrg) {
				            ExisteIdOrg = true;
				            break;
				        }
				    }
				    if (ExisteIdOrg) {
				        System.out.println("Esse ID ja foi cadastrado. Tente novamente!");
				    } else {
				        System.out.println("Nome Pessoal:");
				        String nomeOrg = sc.next();
				        System.out.println("Email:");
				        String emailOrg = sc.next();
				        System.out.println("Empresa: ");
				        String departamento = sc.next();
				        o.add(new Organizador(idOrg, nomeOrg, emailOrg, departamento));
				        System.out.println("Organizador cadastrado com sucesso!");
				    }
				    break;
				case 2:
				    System.out.println("ID do evento:");
				    int idEvento = sc.nextInt();
				    sc.nextLine();
				    boolean ExisteIdEvento = false;
				    for (Evento evento : e) {
				        if (evento.getId() == idEvento) {
				        	ExisteIdEvento = true;
				            break;
				        }
				    }
				    if (ExisteIdEvento) {
				        System.out.println("Evento ja cadastrado. Tente novamente!");
				    } else {
				        System.out.println("Digite o nome do evento:");
				        String nomeEvento = sc.next();
				        System.out.println("Digite o local do evento:");
				        String local = sc.next();
				        System.out.println("Digite a data do evento:");
				        String data = sc.next();
				        e.add(new Evento(idEvento, nomeEvento, data, local));
				        System.out.println("Evento cadastrado com sucesso!");
				    }
				    break;
				case 3:
					System.out.println("Digite o ID do participante:");
				    int idPart = sc.nextInt();
				    sc.nextLine();
				    boolean ExisteIdParticipante = false;
				    for (Participante part : p) {
				        if (part.getId() == idPart) {
				        	ExisteIdParticipante = true;
				            break;
				        }
				    }
				    if (ExisteIdParticipante) {
				        System.out.println("ID já cadastrado. Tente novamente.");
				    } else {
				        System.out.println("Digite o nome do participante:");
				        String nomePart = sc.next();
				        System.out.println("Digite o email do participante:");
				        String emailPart = sc.next();
				        System.out.println("Digite o tipo de ingresso do participante:");
				        String tipoIngresso = sc.next();
				        p.add(new Participante(idPart, nomePart, emailPart, tipoIngresso));
				        System.out.println("Participante cadastrado com sucesso!");
				    }
				    break;
				}
				break;
			case 2:
				System.out.println("--------------------------------");
			    System.out.println("[1] - Listar Organizadores");
			    System.out.println("[2] - Listar Eventos");
			    System.out.println("[3] - Listar Participantes");
			    System.out.println("[4] - Listar Inscrições");
			    System.out.println("--------------------------------");
			    int opcao1 = sc.nextInt();
			    switch (opcao1) {
	            case 1:
	                for (Organizador organizador : o) {
	                    organizador.detalhes();
	                }
	                break;
	            case 2:
	                for (Evento evento : e) {
	                    System.out.println("ID evento: " + evento.getId() 
	                    				+ "\nNome: " + evento.getNome() 
	                    				+ "\nLocal: " + evento.getLocal() 
	                    				+ "\nData: " + evento.getData());
	                }
	                break;
	            case 3:
	                for (Participante participante : p) {
	                    participante.detalhes();
	                }
	                break;
	            case 4:
	            	for(Inscricao inscri : i) {
	            		System.out.println(inscri.toString());
	            	}
	            	break;
	            default:
	                System.out.println("Opção inválida!");
	        }
			break;
			case 3:
				System.out.println("--------------------------------");
		        System.out.println("[1] - Visualizar Organizador");
		        System.out.println("[2] - Visualizar Evento");
		        System.out.println("[3] - Visualizar Participante");
		        System.out.println("[4] - Visualizar Inscrições");
		        System.out.println("--------------------------------");
		        int opcao2 = sc.nextInt();
		        System.out.println("Digite o ID:");
		        int id = sc.nextInt();
		        switch(opcao2) {
		        case 1:
		        	for(Organizador org : o) {
		        		if(org.getId() == id) {
		        			org.detalhes();
		        		} else {
		        			System.out.println("Organizador não encontrado");
		        		}
		        	}
		        break;
		        case 2:
		        	for(Evento eve : e) {
		        		if(eve.getId() == id) {
		        			System.out.println("Evento ID: " + eve.getId()
						        			+ "\nNome: " + eve.getNome()
						        			+ "\nLocal: " + eve.getLocal()
						        			+ "\nData: " + eve.getData()
						        			+ "\n");
		        			} else {
		        			System.out.println("Evento não encontrado!");
		        			}
		        	}
		        break;
		        case 3:
		        	for(Participante par : p) {
		        		if(par.getId() == id) {
		        			par.detalhes();
		        		} else {
		        			System.out.println("Participante não encontrado");
		        		}
		        	}
		        case 4:
		        	for(Inscricao insc : i) {
		        		if(insc.getId() == id) {
		        			System.out.println("ID Inscrição: " + insc.getId() 
		        							+ "Evento: " + insc.getEvento()
		        							+ "Participante: " + insc.getParticipante()
		        							+ "\n");
		        		}
		        	}
		        break;
		        }
		    break;
			case 4:
				System.out.println("--------------------------------");
		        System.out.println("[1] - Remover um Organizador");
		        System.out.println("[2] - Remover um Evento");
		        System.out.println("[3] - Remover um Participante");
		        System.out.println("[4] - Remover uma Inscrição");
		        System.out.println("--------------------------------");
				int opcao3 = sc.nextInt();
				int idRemover;
				switch(opcao3) {
					case 1:
						System.out.println("ID do Organizador: ");
	                    idRemover = sc.nextInt();
	                    o.removeIf(org -> org.getId() == idRemover);
	                    System.out.println("Organizador removido com sucesso!");
	                    break;
					case 2:
						System.out.println("ID do Evento: ");
						idRemover = sc.nextInt();
						e.removeIf(eve -> eve.getId() == idRemover);
						System.out.println("Evento removido com sucesso");
						break;
					case 3:
						System.out.println("ID do Participante");
						idRemover = sc.nextInt();
						p.removeIf(par -> par.getId() == idRemover);
						System.out.println("Participante removido com SCucesso");
						break;
					case 4:
						System.out.println("ID da Inscrição");
						idRemover = sc.nextInt();
						i.removeIf(insc -> insc.getId() == idRemover);
						System.out.println("Inscrição cancelada com sucesso!");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
				}
			break;
			case 5:
				System.out.println("--------------------------------");
		        System.out.println("[1] - Editar Organizador");
		        System.out.println("[2] - Editar Evento");
		        System.out.println("[3] - Editar Participante");
		        System.out.println("--------------------------------");
		        int opcao4 = sc.nextInt();
		        System.out.println("Digite o ID:");
		        int id3 = sc.nextInt();

		        switch (opcao4) {
		            case 1:
		                for (Organizador organizador : o) {
		                    if (organizador.getId() == id3) {
		                        System.out.println("Digite o novo nome do organizador:");
		                        organizador.setNome(sc.next());
		                        System.out.println("Digite o novo email do organizador:");
		                        organizador.setEmail(sc.next());
		                        System.out.println("Digite o novo departamento do organizador:");
		                        organizador.setEmpresa(sc.next());
		                        System.out.println("Organizador editado com sucesso!");
		                    } else {
		                    	System.out.println("Organizador não encontrado!");
		                    }
		                }
		            break;
		            case 2:
		                for (Evento evento : e) {
		                    if (evento.getId() == id3) {
		                        System.out.println("Digite o novo nome do evento:");
		                        evento.setNome(sc.next());
		                        System.out.println("Digite o novo local do evento:");
		                        evento.setLocal(sc.next());
		                        System.out.println("Digite a nova data do evento:");
		                        evento.setData(sc.next());
		                        System.out.println("Evento editado com sucesso!");
		                    } else {
		                    	System.out.println("Evento não encontrado!");
		                    }
		                }
		            break;
		            case 3:
		                for (Participante participante : p) {
		                    if (participante.getId() == id3) {
		                        System.out.println("Digite o novo nome do participante:");
		                        participante.setNome(sc.next());
		                        System.out.println("Digite o novo email do participante:");
		                        participante.setEmail(sc.next());
		                        System.out.println("Digite o novo tipo de ingresso do participante:");
		                        participante.setTipoIngresso(sc.next());
		                        System.out.println("Participante editado com sucesso!");
		                    } else {
		                    	System.out.println("Participante não encontrado!");
		                    }
		                }
		            break;
		            default:
		                System.out.println("Opção inválida!");
		            break;
		        }
		    break;
			case 6:
			    System.out.println("--------------------------");
			    System.out.println("         INSCRIÇÃO        ");
			    System.out.println("--------------------------");

			    System.out.println("ID da inscrição: ");
			    int idInscricao = sc.nextInt();
			    sc.nextLine();
			    
			    boolean ExisteIdInsc = false;
			    for (Organizador org : o) {
			        if (org.getId() == idInscricao) {
			            ExisteIdInsc = true;
			            break;
			        }
			    }
			    if(ExisteIdInsc) {
			    	System.out.println("Inscrição ja existe! Tente novamente com outro ID");
			    } else {
				    System.out.println("ID do participante: ");
				    int idParticipante = sc.nextInt();
				    sc.nextLine();
				    
				    System.out.println("ID do evento");
				    int idEvento = sc.nextInt();
				    sc.nextLine();
				    
				    Evento eventoInscricao = null;
				    for (Evento evento : e) {
				        if (evento.getId() == idEvento) {
				            eventoInscricao = evento;
				            break;
				        }
				    }
				    
				    Participante participanteInscricao = null;
				    for (Participante participante : p) {
				        if (participante.getId() == idParticipante) {
				            participanteInscricao = participante;
				            break;
				        }
				    }
				    
				    if (eventoInscricao == null) {
				        System.out.println("Evento não encontrado");
				    } else if (participanteInscricao == null) {
				        System.out.println("Participante não encontrado");
				    } else {
				        Inscricao novaInscricao = new Inscricao(idInscricao, eventoInscricao, participanteInscricao);
				        i.add(novaInscricao);
				        System.out.println("Inscrição criada com sucesso!");
				    }
				    break;
			    }
			}
		}while(option != 0);
		sc.close();
	}
}
