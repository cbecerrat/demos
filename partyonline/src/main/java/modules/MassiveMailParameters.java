package modules;

import java.util.ArrayList;
import java.util.List;

public class MassiveMailParameters {
	private List<String> receivers;
	private String subject;
	private String content;
	private MailTypes mailType;
	
	public MassiveMailParameters() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getReceivers() {
		if(receivers == null) {
			receivers = new ArrayList<String>();
		}
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MailTypes getMailType() {
		return mailType;
	}

	public void setMailType(MailTypes mailType) {
		this.mailType = mailType;
	}

	@Override
	public String toString() {
		return "MassiveMailParameters [receivers=" + receivers + ", subject=" + subject + ", content=" + content
				+ ", mailType=" + mailType + "]";
	}
}
