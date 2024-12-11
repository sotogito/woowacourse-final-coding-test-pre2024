package domain.controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.constants.Function;
import domain.constants.Payment;
import domain.user.Cart;
import domain.user.Order;
import domain.user.Wallet;
import java.util.List;
import service.OrderService;
import service.PaymentService;
import service.RunService;
import view.InputView;

public class MainController {
    private RunService runService;
    private OrderService orderService;
    private PaymentService paymentService;

    public void run() {
        runService = new RunService();
        Cart cart = new Cart();
        TableRepository tableRepository = new TableRepository();
        MenuRepository menuRepository = new MenuRepository();

        orderService = new OrderService(cart, tableRepository, menuRepository);
        paymentService = new PaymentService(cart, tableRepository);

        while (!runService.isCompleted()) {
            Function function = getFunction();

            if (function.equals(Function.QUIT)) {
                break;
            }
            if (function.equals(Function.ADD_ORDER)) {
                Table table = createTable();
                Menu menu = createMenu();
                int quantity = inputOrderQuantity();
                orderService.order(table, menu, quantity);

            } else if (function.equals(Function.PAYMENT)) {
                Table oldTable = paymentService.findTable(inputPaymentTable());
                List<Order> oldOrders = paymentService.findOrderByTable(oldTable);

                for (Order order : oldOrders) {
                    System.out.println(order);
                }

                Payment payment = Payment.find(InputView.inputPaymentType(oldTable));
                Wallet wallet = paymentService.getPaymentAmount(oldOrders, payment);

                paymentService.deleteTableOder(oldTable);
                System.out.println(wallet);

            }
            System.out.println(cart);

        }

    }

    private Table createTable() {
        return orderService.getTable(InputView.input("## 테이블을 선택하세요."));
    }

    private Menu createMenu() {
        return orderService.getMenu(InputView.input("## 등록할 메뉴를 선택하세요."));
    }

    private int inputOrderQuantity() {
        return InputView.input("## 메뉴의 수량을 입력하세요.");
    }

    private int inputPaymentTable() {
        return InputView.input("## 테이블을 선택하세요.");
    }

    private Function getFunction() {
        return Function.find(InputView.input("## 원하는 기능을 선택하세요."));
    }


}
