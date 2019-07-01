package weekPlan;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dataBase.funtionPlan;
import getPlan.getPlan;

public class weekPlan extends JFrame implements ActionListener {
	// ���� ȭ��
	JPanel mainP, weekP;
	JButton[] btn = new JButton[7];
	String[] week = { "������", "ȭ����", "������", "�����", "�ݿ���", "�����", "�Ͽ���" };
	JLabel acc;

	// ī�� ���̾ƿ�
	CardLayout card = new CardLayout();
	JPanel cp = new JPanel(card);

	// �� ���� ȭ��
	JPanel[] weekd = new JPanel[7];
	JButton[] insert = new JButton[7];
	JButton[] delete = new JButton[7];
	JButton[] back = new JButton[7];
	JTextField[] txt = new JTextField[7];
	JTable[] tab = new JTable[7];

	funtionPlan plan;
	PlanTableModel[] planModel = new PlanTableModel[7];

	public weekPlan() {
		setFrame(); // �ǳ� ��ư �� �߰�
		connectDB();// DB����
		mouseAction();
	}

	private void mouseAction() {
		tab[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[0].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[0].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.monSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[0].setText(gp.getPlan());
			}
		});
		tab[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[1].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[1].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.tuesSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[1].setText(gp.getPlan());
			}
		});
		tab[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[2].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[2].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.wednesSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[2].setText(gp.getPlan());
			}
		});
		tab[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[3].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[3].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.thursSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[3].setText(gp.getPlan());
			}
		});
		tab[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[4].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[4].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.friSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[4].setText(gp.getPlan());
			}
		});
		tab[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[5].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[5].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.saturSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[5].setText(gp.getPlan());
			}
		});
		tab[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tab[6].getSelectedRow();
				int col = 0;
				// Ŭ�����ڵ� ������ȣ ���
				String data = (String) tab[6].getValueAt(row, col);
				String no = data;

				try {
					getPlan gp = plan.sunSelect(no);
					selectbyPk(gp);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			private void selectbyPk(getPlan gp) {
				txt[6].setText(gp.getPlan());
			}
		});
	}

	public void connectDB() {
		try {
			plan = new funtionPlan();
			System.out.println("DB ���� ����");
		} catch (Exception e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
		}
	}

	// �ǳ� ��ư �� �߰�
	private void setFrame() {
		setSize(700, 300);
		setTitle("�ְ���ȹǥ"); 
		setLayout(card);

		// �ǳ��߰�
		mainP = new JPanel(); // ���� �ǳ�
		weekP = new JPanel(); // ������ �߰��� �ǳ�

		cp.add(mainP, "�������");

		// ���� ��ư �߰�
		createComponent();

		JPanel funtion1 = new JPanel();

		// �ǳ� setLayout
		weekP.setLayout(new GridLayout(1, 7));
		mainP.setLayout(new BorderLayout());

		mainP.add(weekP, BorderLayout.CENTER);
		add(cp);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void createComponent() {
		for (int i = 0; i < week.length; i++) {
			btn[i] = new JButton(week[i]);
			back[i] = new JButton("�ڷ�");
			insert[i] = new JButton("���");
			delete[i] = new JButton("����");
			txt[i] = new JTextField(30);
			planModel[i] = new PlanTableModel();
			tab[i] = new JTable(planModel[i]);
			tab[i].setModel(planModel[i]);

			weekd[i] = new JPanel();

			insert[i].addActionListener(this);
			delete[i].addActionListener(this);
			back[i].addActionListener(this);
			btn[i].addActionListener(this);
			txt[i].addActionListener(this);

			weekd[i].add(back[i], BorderLayout.NORTH);
			weekd[i].add(txt[i], BorderLayout.NORTH);
			weekd[i].add(insert[i], BorderLayout.NORTH);
			weekd[i].add(delete[i], BorderLayout.NORTH);
			weekd[i].add(tab[i], BorderLayout.SOUTH);
			weekd[i].add(new JScrollPane(tab[i]), BorderLayout.CENTER);
			
			weekP.add(btn[i]);

			add(weekd[i]);

			cp.add(weekd[i], week[i]);
		}
	}

	class PlanTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "��ȹ" };

		@Override
		public int getColumnCount() {

			return columnNames.length;
		}

		@Override
		public int getRowCount() {

			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		panelMove(evt);
		insertPlan(evt);
		deletePlan(evt);
		searchPlan(evt);

	}

	private void searchPlan(Object evt) {
		if (evt == txt[0]) {
			String str = txt[0].getText();
			try {
				ArrayList data = plan.monSearch(str);
				planModel[0].data = data;
				tab[0].setModel(planModel[0]);
				planModel[0].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[1]) {
			String str = txt[1].getText();
			try {
				ArrayList data = plan.tuesSearch(str);
				planModel[1].data = data;
				tab[1].setModel(planModel[1]);
				planModel[1].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[2]) {
			String str = txt[2].getText();
			try {
				ArrayList data = plan.wednesSearch(str);
				planModel[2].data = data;
				tab[2].setModel(planModel[2]);
				planModel[2].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[3]) {
			String str = txt[3].getText();
			try {
				ArrayList data = plan.thursSearch(str);
				planModel[3].data = data;
				tab[3].setModel(planModel[3]);
				planModel[3].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[4]) {
			String str = txt[4].getText();
			try {
				ArrayList data = plan.friSearch(str);
				planModel[4].data = data;
				tab[4].setModel(planModel[4]);
				planModel[4].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[5]) {
			String str = txt[5].getText();
			try {
				ArrayList data = plan.saturSearch(str);
				planModel[5].data = data;
				tab[5].setModel(planModel[5]);
				planModel[5].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (evt == txt[6]) {
			String str = txt[6].getText();
			try {
				ArrayList data = plan.sunSearch(str);
				planModel[6].data = data;
				tab[6].setModel(planModel[6]);
				planModel[6].fireTableDataChanged();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void deletePlan(Object evt) {
		if (evt == delete[0]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[0].getText());
			try {
				plan.monDelete(gp);
				txt[0].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[1]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[1].getText());
			try {
				plan.tuesDelete(gp);
				txt[1].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[2]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[2].getText());
			try {
				plan.wednesDelete(gp);
				txt[2].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[3]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[3].getText());
			try {
				plan.thursDelete(gp);
				txt[3].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[4]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[4].getText());
			try {
				plan.friDelete(gp);
				txt[4].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[5]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[5].getText());
			try {
				plan.saturDelete(gp);
				txt[5].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		} else if (evt == delete[6]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[6].getText());
			try {
				plan.sunDelete(gp);
				txt[6].setText(null);
				JOptionPane.showMessageDialog(null, "�����Ϸ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������");
			}
		}
	}

	private void insertPlan(Object evt) {
		if (evt == insert[0]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[0].getText());
			try {
				plan.monPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[0].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[1]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[1].getText());
			try {
				plan.tuesPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[1].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[2]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[2].getText());
			try {
				plan.wednesPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[2].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[3]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[3].getText());
			try {
				plan.thursPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[3].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[4]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[4].getText());
			try {
				plan.friPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[4].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[5]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[5].getText());
			try {
				plan.saturPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[5].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		} else if (evt == insert[6]) {
			getPlan gp = new getPlan();
			gp.setPlan(txt[6].getText());
			try {
				plan.sunPlan(gp);
				JOptionPane.showMessageDialog(null, "��ϿϷ�");
				txt[6].setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��Ͻ���");
				e1.printStackTrace();
			}
		}
	}

	private void panelMove(Object evt) {
		if (evt == back[0] || evt == back[1] || evt == back[2] || evt == back[3] || evt == back[4] || evt == back[5]
				|| evt == back[6]) {
			card.show(cp, "�������");
		}
		if (evt == btn[0]) {
			card.show(cp, "������");
		} else if (evt == btn[1]) {
			card.show(cp, "ȭ����");
		} else if (evt == btn[2]) {
			card.show(cp, "������");
		} else if (evt == btn[3]) {
			card.show(cp, "�����");
		} else if (evt == btn[4]) {
			card.show(cp, "�ݿ���");
		} else if (evt == btn[5]) {
			card.show(cp, "�����");
		} else if (evt == btn[6]) {
			card.show(cp, "�Ͽ���");
		}
	}

	public static void main(String[] args) {
		weekPlan w = new weekPlan();
	}
}
