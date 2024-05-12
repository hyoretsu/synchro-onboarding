import Modal from "@components/Modal";
import { OpacityFilter } from "@hyoretsu/react-components";
import EditingForm from "./components/Form";

export default function AccountEditing() {
	return (
		<OpacityFilter>
			<Modal>
				<EditingForm />
			</Modal>
		</OpacityFilter>
	);
}
