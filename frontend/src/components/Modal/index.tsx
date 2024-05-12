// import type { Dispatch, SetStateAction } from "react";
import type { ReactNode } from "react";
import styles from "./styles.module.scss";

interface ModalProps {
	children: ReactNode;
	// setState: Dispatch<SetStateAction<boolean>>;
}

export default async function Modal({ children }: ModalProps) {
	return <div className={styles.modal}>{children}</div>;
}
